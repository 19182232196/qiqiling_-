dic={"燃气费":126.00,"水费":12.00,"电费":12.00,"网费":12.00,"房租":12000.00,"伙食费":1200.00,"交通费":1200.00}
test=input("请输入要查询的消费项目： ")
if test=="燃气费":
    print("燃气费",dic.get(test,"nothing"))
if test=="水费":
    print("水费",dic.get(test,"nothing"))
if test=="电费":
    print("电费",dic.get(test,"nothing"))
if test=="网费":
    print("网费",dic.get(test,"nothing"))
if test=="房租":
    print("房租",dic.get(test,"nothing"))
if test=="伙食费":
    print("伙食费",dic.get(test,"nothing"))
if test=="交通费":
    print("交通费",dic.get(test,"nothing"))