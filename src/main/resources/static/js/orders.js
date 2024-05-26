document.addEventListener('DOMContentLoaded', function() {
    const orderForm = document.getElementById('orderForm');
    const orderList = document.getElementById('orderList');

    orderForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const formData = new FormData(orderForm);
        const items = [];
        const itemFields = orderForm.querySelectorAll('[name="productId"]');
        itemFields.forEach((field, index) => {
            items.push({
                productId: field.value,
                quantity: orderForm.querySelectorAll('[name="quantity"]')[index].value
            });
        });

        const orderData = {
            customerName: formData.get('customerName'),
            items: items
        };

        fetch('/api/orders', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(orderData)
        })
        .then(response => response.json())
        .then(data => {
            fetchOrders();
            orderForm.reset();
        })
        .catch(error => console.error('Error:', error));
    });

    function fetchOrders() {
        fetch('/api/orders')
            .then(response => response.json())
            .then(data => {
                orderList.innerHTML = '';
                data.forEach(order => {
                    const li = document.createElement('li');
                    li.textContent = `${order.customerName} - ${order.status}`;
                    const deleteButton = document.createElement('button');
                    deleteButton.textContent = 'Delete';
                    deleteButton.onclick = function() {
                        deleteOrder(order.id);
                    };
                    li.appendChild(deleteButton);
                    orderList.appendChild(li);
                });
            });
    }

    function deleteOrder(orderId) {
        fetch(`/api/orders/${orderId}`, {
            method: 'DELETE'
        })
        .then(() => fetchOrders())
        .catch(error => console.error('Error:', error));
    }

    function addItem() {
        const itemContainer = document.getElementById('itemsContainer');
        const itemDiv = document.createElement('div');
        itemDiv.innerHTML = `
            <input type="text" name="productId" placeholder="Product ID" required>
            <input type="number" name="quantity" placeholder="Quantity" required>
        `;
        itemContainer.appendChild(itemDiv);
    }

    fetchOrders();
});
