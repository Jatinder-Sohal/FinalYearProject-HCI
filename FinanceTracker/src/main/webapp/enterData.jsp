<head>
    <meta charset="ISO-8859-1">
    <title>Enter Data</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="enterData.css">
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
                <a class="nav-link" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="#">Enter data</a>
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
    
    <div class="form-container">
      <h2>Please input your finances below</h2>
      <div>
        <table class="table table-striped table-dark" id="userTable">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Expense/Income?</th>
              <th scope="col">Amount</th>
              <th scope="col">Last years amount</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">1</th>
              <td><input type="text" class="form-control" placeholder="First name"></td>
              <td><input type="text" class="form-control" placeholder="First name"></td>
              <td><input type="text" class="form-control" placeholder="First name"></td>
            </tr>
          </tbody>
        </table>     
        <button onclick="addRow()">Add Row</button>
      </div>
    </div>
    
    
    <script>
      function initaliseTable(){
        for(let i=0; i < 4; i++){
          var table = document.getElementById("userTable");
          var newRow = table.insertRow(table.rows.length);

          var cell1 = newRow.insertCell(0);
          var cell2 = newRow.insertCell(1);
          var cell3 = newRow.insertCell(2);
          var cell4 = newRow.insertCell(3);
          var rowNumber = table.rows.length - 1; 
          cell1.innerHTML = rowNumber;
          cell2.innerHTML = '<input type="text" class="form-control">';
          cell3.innerHTML = '<input type="text" class="form-control">';
          cell4.innerHTML = '<input type="text" class="form-control">';
        }
      }
      initaliseTable();
      function addRow() {
        var table = document.getElementById("userTable");
        var newRow = table.insertRow(table.rows.length);
        
        var cell1 = newRow.insertCell(0);
        var cell2 = newRow.insertCell(1);
        var cell3 = newRow.insertCell(2);
        var cell4 = newRow.insertCell(3);
    
        var rowNumber = table.rows.length - 1;
        cell1.innerHTML = rowNumber;
        cell2.innerHTML = prompt("Enter First Name");
        cell3.innerHTML = prompt("Enter Last Name");
        cell4.innerHTML = prompt("Enter Handle");
      }
    </script>  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>    
</body>