// 模拟商品数据
const products = [
    { id: 1, name: '商品1', price: 20 },
    { id: 2, name: '商品2', price: 30 },
    { id: 3, name: '商品3', price: 25 }
];

// 初始化购物车
let cart = [];

// 添加商品到购物车
function addToCart(productId) {
    const product = products.find(item => item.id === productId);
    cart.push(product);
    renderCart();
}

// 渲染购物车
function renderCart() {
    const cartList = document.getElementById('cart');
    cartList.innerHTML = '';

    cart.forEach(product => {
        const listItem = document.createElement('li');
        listItem.className = 'list-group-item';
        listItem.textContent = `${product.name} - ￥${product.price}`;
        cartList.appendChild(listItem);
    });
}

// 结算
function checkout() {
    let total = 0;
    cart.forEach(product => {
        total += product.price;
    });

    alert(`总计：￥${total}`);
}
