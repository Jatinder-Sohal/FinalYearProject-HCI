<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width">
    <title>Enter Data</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="Input.css">
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
              <td><input type="text" class="form-control" placeholder="First name" aria-label="First name"></td>
              <td><input type="text" class="form-control" placeholder="First name" aria-label="First name"></td>
              <td><input type="text" class="form-control" placeholder="First name" aria-label="First name"></td>
            </tr>
          </tbody>
        </table>    
        <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" onclick="addRows(1)" class="bi bi-file-plus-fill" viewBox="0 0 16 16" id="addRow">
          <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM8.5 6v1.5H10a.5.5 0 0 1 0 1H8.5V10a.5.5 0 0 1-1 0V8.5H6a.5.5 0 0 1 0-1h1.5V6a.5.5 0 0 1 1 0z"/>
        </svg>
        <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" onclick="deleteRows(1)" class="bi bi-file-minus-fill" viewBox="0 0 16 16" id="deleteRow">
          <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM6 7.5h4a.5.5 0 0 1 0 1H6a.5.5 0 0 1 0-1z"/>
        </svg>
        <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-backspace-fill" viewBox="0 0 16 16" id="restart">
          <path d="M15.683 3a2 2 0 0 0-2-2h-7.08a2 2 0 0 0-1.519.698L.241 7.35a1 1 0 0 0 0 1.302l4.843 5.65A2 2 0 0 0 6.603 15h7.08a2 2 0 0 0 2-2V3zM5.829 5.854a.5.5 0 1 1 .707-.708l2.147 2.147 2.146-2.147a.5.5 0 1 1 .707.708L9.39 8l2.146 2.146a.5.5 0 0 1-.707.708L8.683 8.707l-2.147 2.147a.5.5 0 0 1-.707-.708L7.976 8 5.829 5.854z"/>
        </svg>
      </div>
    </div>
    
    <script>
      function addRows(rowNumber){
        for(let i=0; i < rowNumber; i++){
          var table = document.getElementById("userTable");
          var newRow = table.insertRow(table.rows.length);

          var cell1 = newRow.insertCell(0);
          var cell2 = newRow.insertCell(1);
          var cell3 = newRow.insertCell(2);
          var cell4 = newRow.insertCell(3);
          var rowIndex = table.rows.length - 1;

          cell1.innerHTML = rowIndex;
          cell2.innerHTML = '<input type="text" class="form-control" aria-label="First name">';
          cell3.innerHTML = '<input type="text" class="form-control" aria-label="First name">';
          cell4.innerHTML = '<input type="text" class="form-control" aria-label="First name">';
        }
      }
      addRows(2);
    </script>  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>    
</body>

