document.addEventListener('DOMContentLoaded', function() {
    const paymentForm = document.getElementById('paymentForm');

    paymentForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const formData = new FormData(paymentForm);

        const paymentData = {
            orderId: formData.get('orderId'),
            amount: formData.get('amount'),
            paymentMethod: formData.get('paymentMethod'),
            paymentDetails: formData.get('paymentDetails')
        };

        fetch(`/api/orders/${paymentData.orderId}/payment`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(paymentData)
        })
        .then(response => response.json())
        .then(data => {
            paymentForm.reset();
            alert('Payment processed successfully');
        })
        .catch(error => console.error('Error:', error));
    });
});
