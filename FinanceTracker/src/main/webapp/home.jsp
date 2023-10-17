<head>
  <meta charset="ISO-8859-1">
  <title>Home</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <link rel="stylesheet" href="home.css">
</head>
<body>
  <nav class="navbar navbar-expand-lg bg-custom-2" data-bs-theme="dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Financial Tracker</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="#">Enter data</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Select Output
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Plain text</a></li>
              <li><hr class="dropdown-divider"></li>
              <li><a class="dropdown-item" href="#">Pie chart</a></li>
              <li><hr class="dropdown-divider"></li>
              <li><a class="dropdown-item" href="#">Line graph</a></li>
              <li><hr class="dropdown-divider"></li>
              <li><a class="dropdown-item" href="#">Bar graph</a></li>
            </ul>
          </li>       
        </ul>
        <span class="navbar-text">
          <button type="button" class="btn btn-outline-info">Need help?</button>
        </span>
      </div>
    </div>
  </nav>
  <div class="text-center">
    </br>
      <h1>Financial </h1>
      <h1>Tracker</h1>
      <h2>Keep track of your spending habits</h2>
    </br>
    <button type="button" class="btn btn-primary btn-lg">
      Get Started
      <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
        <path d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"></path>
      </svg>    
    </button>
  </div>
  <div class="row">
    <div class="col" style="max-width: 18rem;">
      <div class="card bg-custom-1 mb-3" style="height: 100%;">
        <div class="card-header"><h5 class="card-title">How to use</h5></div>
        <div class="card-body">
          <p class="card-text">Start by entering your income and key expenditures into the calculator, which will provide you with a visual breakdown </p>
        </div>
      </div>
    </div>
    <div class="col" style="max-width: 18rem;">
      <div class="card bg-custom-1 mb-3" style="height: 100%;">
        <div class="card-header"><h5 class="card-title">Benefits?</h5></div>
        <div class="card-body">
          <p class="card-text">The calculator will show several ways to view the results, calculate taxed owed, and even provide some recommendations on how to cut costs</p>
        </div>
      </div>
    </div>
    <div class="col" style="max-width: 18rem;">
      <div class="card bg-custom-1 mb-3" style="height: 100%;">
        <div class="card-header"><h5 class="card-title">I entered a wrong value</h5></div>
        <div class="card-body">
          <p class="card-text">You can reset the calculator by clicking the refresh button which will start the process again. If you need extra help please click the button in the top right of the page</p>
        </div>
      </div>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>