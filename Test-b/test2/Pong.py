import pygame, sys, random, math

WIDTH = 1200
HEIGHT = 600
SPEED = 5
FPS = 120
leftscore = 0
rightscore = 0

pygame.init()
Window = pygame.display.set_mode((WIDTH, HEIGHT))
clock = pygame.time.Clock()

theta = random.uniform(0, 2) * math.pi
speed_x = SPEED
speed_y = SPEED

ball = pygame.Surface((40, 40))
ball.fill('white')
ball_rect = ball.get_rect(center=(int(WIDTH / 2), int(HEIGHT / 2)))

left_racket = pygame.Surface((20, 180))
left_racket.fill('white')
left_racket_rect = left_racket.get_rect(midleft=(50, int(HEIGHT / 2)))

right_racket = pygame.Surface((20, 180))
right_racket.fill('white')
right_racket_rect = right_racket.get_rect(midright=(WIDTH - 50, int(HEIGHT / 2)))

net = pygame.Surface((10, HEIGHT))
net.fill('white')
net_rect = net.get_rect(center=(int(WIDTH / 2), int(HEIGHT / 2)))

my_font = pygame.font.Font('C:\\WINDOWS\\Fonts\\simhei.ttf', 50)

game_on = True

while True:

    clock.tick(FPS)

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_SPACE:
                leftscore = 0
                rightscore = 0
                speed_x = SPEED
                theta = random.uniform(0, 2) * math.pi
                ball_rect.center = (int(WIDTH / 2), int(HEIGHT / 2))
                game_on = True

    if game_on:

        ball_rect[0] += speed_x * math.cos(theta)
        ball_rect[1] += speed_y * math.sin(theta)

        mx = pygame.mouse.get_pos()[1]
        left_racket_rect[1] = pygame.mouse.get_pos()[1]
        right_racket_rect[1] = pygame.mouse.get_pos()[1]

        if ball_rect.top <= 0 or ball_rect.bottom >= HEIGHT:
            speed_y *= -1
            if speed_y > 0:
                speed_y += 3
                theta = random.uniform(0, 2) * math.pi
                speed_y = SPEED
            else:
                speed_y -= 3
                theta = random.uniform(0, 2) * math.pi
                speed_y = SPEED

        if left_racket_rect.colliderect(ball_rect) or right_racket_rect.colliderect(ball_rect):
            speed_x *= -1
            if speed_x > 0:
                speed_x += 3
                theta = random.uniform(0, 2) * math.pi

            else:
                speed_x -= 3
                theta = random.uniform(0, 2) * math.pi

        left_score = my_font.render(str(leftscore), True, 'white')
        left_score_rect = left_score.get_rect(center=(int(WIDTH / 4), 100))

        right_score = my_font.render(str(rightscore), True, 'white')
        right_score_rect = right_score.get_rect(center=(int(3 * WIDTH / 4), 100))

        if ball_rect.left < left_racket_rect.right and not left_racket_rect.colliderect(ball_rect):
            rightscore += 1

            theta = random.uniform(0, 2) * math.pi
            ball_rect.center = (int(WIDTH / 2), int(HEIGHT / 2))
            pygame.time.wait(1000)
            speed_x = SPEED
            speed_y = SPEED

        if ball_rect.right > right_racket_rect.left and not right_racket_rect.colliderect(ball_rect):
            leftscore += 1

            theta = random.uniform(0, 2) * math.pi
            ball_rect.center = (int(WIDTH / 2), int(HEIGHT / 2))
            pygame.time.wait(1000)
            speed_x = SPEED
            speed_y = SPEED

        if leftscore == 3:
            print("left_win!")
            game_on = False

        if rightscore == 3:
            print("right_win!")
            game_on = False

        Window.fill('black')
        Window.blit(left_racket, left_racket_rect)
        Window.blit(right_racket, right_racket_rect)
        Window.blit(net, net_rect)
        Window.blit(ball, ball_rect)
        Window.blit(left_score, left_score_rect)
        Window.blit(right_score, right_score_rect)

    pygame.display.update()
