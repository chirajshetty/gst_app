fetch("http://localhost:8080/products", {
    method:'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body : JSON.stringify({
        "code":"ITM102",
        "gst":12,
        "name":"Mangoes",
        "price":500.00
    })
})
.then(res => res.json())
.then(data => console.log(data))

fetch("http://localhost:8080/product/id/ITM102",)
    .then(res => res.json())
    .then(data => console.log(data))