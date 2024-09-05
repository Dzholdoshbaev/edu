<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Orders</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>

<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <a href="/" class="text-dark mx-2" aria-label="Orders">
                <i class="fas fa-shopping-cart"></i>
                <span class="badge bg-danger">3</span>
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
            <a href="/auth/login"
               class="btn btn-outline-info m-2">Login</a>
            <a href="/profile/register"
               class="btn btn-outline-info m-2">Register</a>
        </#if>

    </nav>
</header>

<body>
<div class="container mt-4">
    <h1>Your Orders</h1>

    <#if dishes?size == 0>
        <p>No items in your order.</p>

    <#else>
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
            <#list dishes as dish>
                <tr>
                    <td>${dish.id}</td>
                    <td>${dish.name}</td>
                    <td>${dish.price}</td>
                </tr>
            </#list>
            </tbody>
        </table>

        <form action="/orders/confirm" method="post">
            <button type="submit" class="btn btn-primary">Confirm Order</button>
        </form>

    </#if>
</div>
</body>
</html>
