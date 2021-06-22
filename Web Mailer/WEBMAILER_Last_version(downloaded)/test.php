<?php
 if($_SERVER["REQUEST_METHOD"]=="POST"){
    $example = $_POST['example'];
    
    echo $example ;}
  
?>

<form  method="post">
  <input name="example" type="text" />
 
  <input name="submit" type="submit" />
</form>