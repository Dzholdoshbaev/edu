<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurants List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            max-width: 1200px;
            margin: auto;
        }
        .restaurant-list {
            list-style-type: none;
            padding: 0;
        }
        .restaurant-item {
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #f9f9f9;
        }
        .restaurant-item h2 {
            margin-top: 0;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .pagination {
            justify-content: center;
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
                <span class="badge bg-danger">!</span>
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
    <h1>Restaurants</h1>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <#if restaurants.hasPrevious()>
                <li class="page-item"><a class="page-link" href="/?page=${restaurants.number - 1}">Previous</a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
            </#if>

            <#list 0..(restaurants.totalPages - 1) as page>
                <li class="page-item <#if restaurants.number == page>active</#if>">
                    <a class="page-link" href="/?page=${page}">${page + 1}</a>
                </li>
            </#list>

            <#if restaurants.hasNext()>
                <li class="page-item"><a class="page-link" href="/?page=${restaurants.number + 1}">Next</a></li>
            <#else>
                <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
            </#if>
        </ul>
    </nav>

    <ul class="restaurant-list">
        <#list restaurants.content as restaurant>
            <li class="restaurant-item">
                <h2><a href="/restaurants/${restaurant.id}" class="btn btn-primary">${restaurant.name}</a></h2>
                <p><strong>Address:</strong> ${restaurant.address}</p>
                <p><strong>Description:</strong> ${restaurant.description}</p>
            </li>
        </#list>
    </ul>
</div>
</body>
</html>
