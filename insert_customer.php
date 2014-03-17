<html>
<head>
  <title>Book-O-Rama Book Entry Results</title>
</head>
<body>
<h1>Book-O-Rama Customer Entry Results</h1>
<?php
  // create short variable names
  $customerid=$_POST['customerid'];
  $name=$_POST['name'];
  $address=$_POST['address'];
  $city=$_POST['city'];

  if (!$customerid || !$name || !$address || !$city) {
     echo "You have not entered all the required details.<br />"
          ."Please go back and try again.";
     exit;
  }

  if (!get_magic_quotes_gpc()) {
    $customerid = addslashes($customerid);
    $name = addslashes($name);
    $address = addslashes($address);
    $city = addslashes($city);
  }

  @ $db = new mysqli('localhost', 'mohta', '1987', 'bookorama');

  if (mysqli_connect_errno()) {
     echo "Error: Could not connect to database.  Please try again later.";
     exit;
  }

  $query = "insert into customers values
            ('".$customerid."', '".$name."', '".$address."', '".$city."')";
  $result = $db->query($query);

  if ($result) {
      echo  $db->affected_rows." customer inserted into database.";
  } else {
  	  echo "An error has occurred.  The item was not added.";
  }

  $db->close();
?>
</body>
</html>
