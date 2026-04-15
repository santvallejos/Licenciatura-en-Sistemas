<!DOCTYPE html>
<html>

<head>
    <title>Mensaje enviado</title>
    <link rel="stylesheet" href="{{ asset('bootstrap/css/bootstrap.min.css') }}">
</head>

<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Mi Sitio</a>
            <div class="navbar-nav">
                <a class="nav-link" href="/">Inicio</a>
                <a class="nav-link" href="/aboutme">Sobre mí</a>
                <a class="nav-link" href="/contacto">Contacto</a>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <div class="card">
            <div class="card-body text-center">
                <h1 class="card-title">¡Mensaje enviado!</h1>
                <p class="lead">
                    Hola <strong>{{ $nombre }}</strong>, qué bueno recibir tu mensaje. Un miembro del equipo de ventas se pondrá en contacto con vos al correo: <strong>{{ $email }}</strong> ¡Muchas gracias!
                </p>
                <a href="/contacto" class="btn btn-primary mt-3">Volver al formulario</a>
            </div>
        </div>
    </div>

    <script src="{{ asset('bootstrap/js/bootstrap.bundle.min.js') }}"></script>

</body>

</html>
