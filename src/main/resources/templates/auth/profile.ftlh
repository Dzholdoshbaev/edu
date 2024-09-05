<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <style>
        .profile-container {
            margin-top: 30px;
        }
        .profile-img {
            width: 150px;
            height: 150px;
            object-fit: cover;
            border-radius: 50%;
            border: 2px solid #ddd;
            margin-bottom: 15px;
        }
        .form-control-file {
            border: 1px solid #ced4da;
            border-radius: 0.25rem;
        }
        .btn-outline-info {
            margin-top: 10px;
        }
        .card-title {
            font-size: 1.5rem;
        }
        .card-text {
            font-size: 1rem;
        }
        .order-table th, .order-table td {
            text-align: center;
        }
    </style>
</head>
<body>
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
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
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

<div class="container profile-container">
    <div class="row">
        <div class="col-md-4 text-center">
            <#if userDto??>
                <#if userDto.avatar?? && userDto.avatar?has_content>
                    <img src="./images/${userDto.avatar}" alt="ProfilePhoto" class="profile-img"/>
                <#else>
                    <img src="/static/images/nophoto.jpg" alt="ProfilePhoto" class="profile-img"/>
                </#if>
            <#else>
                <img src="/static/images/nophoto.jpg" alt="ProfilePhoto" class="profile-img"/>
            </#if>
            <form action="/images" method="post" enctype="multipart/form-data" class="mt-3">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}" value="${(_csrf.token)!'csrf-token'}"/>
                </#if>
                <input type="file" name="file"/>
                <button type="submit" class="btn btn-outline-info">Change Photo</button>
            </form>
        </div>
        <div class="col-md-8">
            <h3 class="card-title">${userDto.name!"Not specified"} ${userDto.surname!"Not specified"}</h3>
            <p class="card-text"><strong>Age:</strong> ${userDto.age!"Not specified"}</p>
            <p class="card-text"><strong>Email:</strong> ${userDto.email!"Not specified"}</p>
            <p class="card-text"><strong>Phone Number:</strong> ${userDto.phoneNumber!"User Without Phone"}</p>
        </div>
    </div>

    <div class="row mt-5">
        <div class="col-md-12">
            <h4>Orders</h4>
            <table class="table table-bordered order-table">
                <thead>
                <tr>
                    <th>Total Amount</th>
                    <th>Order Date</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <#list orders as order>
                    <tr>
                        <td>${order.totalAmount}</td>
                        <td>${order.orderDate}</td>
                        <td>${order.status}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
