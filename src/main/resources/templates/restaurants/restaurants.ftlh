<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            max-width: 1200px;
            margin: auto;
        }
        .restaurant-details {
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 20px;
            background-color: #f9f9f9;
            margin-bottom: 20px;
        }
        .restaurant-details h1 {
            margin-top: 0;
        }
        .dishes-list {
            list-style-type: none;
            padding: 0;
        }
        .dish-item {
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #f9f9f9;
        }
        .dish-item h3 {
            margin-top: 0;
        }
        .pagination {
            justify-content: center;
        }
        .order-button {
            display: inline-block;
            padding: 10px 15px;
            margin-top: 10px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1em;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .order-button:hover {
            background-color: #0056b3;
        }
        .order-button i {
            margin-right: 5px;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>

<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <a href="/orders/order" class="text-dark mx-2" aria-label="Orders">
                <i class="fas fa-shopping-cart"></i>
                <span class="badge bg-danger">${count!"0"}</span>
            </a>
        </div>
        <#assign known = SPRING_SECURITY_CONTEXT?? >
        <#if known>
            <#assign
            user = SPRING_SECURITY_CONTEXT.authentication.principal
            name = user.getUsername()
            >
            <a href="/profile" class="text-dark m-2 m-sm-0">
                <span class="btn btn-outline-info m-2">Profile</span>
            </a>

            <#if _csrf??>
                <form action="/auth/logout" method="post">
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                           value="${(_csrf.token)!'--no-token--'}"/>
                    <button type="submit" class="btn btn-outline-info m-2" id="logout">Logout</button>
                </form>
            <#else>
                <a href="/auth/logout" class="btn btn-outline-info m-2" id="logout">Logout</a>
            </#if>
        <#else>
            <a href="/auth/login" class="btn btn-outline-info m-2">Login</a>
            <a href="/profile/register" class="btn btn-outline-info m-2">Register</a>
        </#if>
    </nav>
</header>

<body>
<div class="container">
    <div class="restaurant-details">
        <h1>${restaurants.name}</h1>
        <p><strong>Address:</strong> ${restaurants.address}</p>
        <p><strong>Description:</strong> ${restaurants.description}</p>
    </div>

    <h2>Menu</h2>
    <ul class="dishes-list">
        <#list restaurantDishes.content as dish>
            <li class="dish-item">
                <h3>${dish.name}</h3>
                <p><strong>Description:</strong> ${dish.description}</p>
                <p><strong>Price:</strong> $${dish.price}</p>
                <a href="/orders/${dish.id}" class="btn btn-primary">
                    <i class="bi bi-cart-plus"></i> Order
                </a>
            </li>
        </#list>
    </ul>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <#if restaurantDishes.hasPrevious()>
                <li class="page-item"><a class="page-link" href="/restaurants/${restaurants.id}?page=${restaurantDishes.number - 1}">Previous</a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
            </#if>

            <#list 0..(restaurantDishes.totalPages - 1) as page>
                <li class="page-item <#if restaurantDishes.number == page>active</#if>">
                    <a class="page-link" href="/restaurants/${restaurants.id}?page=${page}">${page + 1}</a>
                </li>
            </#list>

            <#if restaurantDishes.hasNext()>
                <li class="page-item"><a class="page-link" href="/restaurants/${restaurants.id}?page=${restaurantDishes.number + 1}">Next</a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
            </#if>
        </ul>
    </nav>
</div>
</body>
</html>
