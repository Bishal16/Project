<?php
session_start();
?>



<?php



$server      = "localhost";
$password    = "hsq7B5DLJvjVMUKX";
$user        = "ourcuet_bishal";
$database    = "ourcuet_bishaldbms3";

$current_user_mail=$_SESSION["user_mail"];
$connection = mysqli_connect($server, $user, $password, $database);
    

        $sql= "SELECT * from inbox where s_email='$current_user_mail'";
        $query = mysqli_query($connection,$sql);
        $rownum = mysqli_num_rows($query);
        
        $arr=array();
        $id=array();
        $i=0;
        while($row = mysqli_fetch_assoc($query)) 
        {
            $arr[$i]=$row['title']; 
            $id[$i]=$row['id'];
            $i++;
        }
$i=0;
    
mysqli_close($connection);

?>



<!DOCTYPE html>
<html lang="en">

<head>
    <title>Web Mailer</title>
    <link rel="stylesheet" href="style1.css">
    <link rel="stylesheet" href="styles.css">
</head>

<body>

            <div id="header">
                    <h1 >Web Mailer</h1>
                    <button  title="Profile" class="profile_icon" onclick="window.location='profile.php'">  </button>     
                    <div class="ppp">   <?php echo $_SESSION["user_mail"] ; ?></div>
            </div>
    <div id="main_div">
        <div class="sidebar">
            <ul>
                <li><a href="compose.php">Compose</a></li>
                <li><a href="inbox.php">Inbox</a></li>
                <li><a class="active" href="sentbox.php">Sent</a></li>
                <li><a href="draft.php">Draft</a></li>
                <li><a href="trash.php">Trash</a></li>
                <li ><a href="profile.php">Profile</a></li>
                <li ><a href="logout.php">Logout</a></li>
            </ul>
             <!--  -->
             <form method="post" action="inbox.php" name=search>
                <input class="search_area" name="search" type="text" placeholder="search..." >
                <input type="submit" name=searchbtn value="search" class="searchbtn">
            </form>
    <!--  -->
        </div>
        <div class="main_body" id="inboxDiv">
            

            <?php while($rownum--){ ?>
            <div class="inbox">

                <a class="title" href="sentbox2.php?qtitle=<?php echo $id[$i];?>&delete=0">
                    <?php echo $arr[$i]; ?>      
                </a>
               <button title="delete" class="del_button" onclick="window.location='sentbox2.php?qtitle=0&delete=<?php echo $id[$i];?>'">  </button>     
                    <?php     $i++; ?>

            </div>
            <?php } ?>
            <br><br><br><br><br><br><br><br><br><br><br><br>


            <br><br><br><br><br><br><br><br><br><br><br><br>
        </div>

       
    </div>
</body>

</html>
