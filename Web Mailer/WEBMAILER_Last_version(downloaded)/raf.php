    <?php

$var= 5;
$title;
echo "tor mayere bap";

$server      = "localhost";
$password    = "";
$user        = "root";
$database    = "mailservice";

$connection = mysqli_connect($server, $user, $password, $database);
if($_SERVER["REQUEST_METHOD"]=="POST"){
    echo "tor mayere bapq2";
        $result=mysql_query("SELECT count(*) as total from inbox");
$data=mysql_fetch_assoc($result);
    
    
}

mysqli_close($connection);

?>
