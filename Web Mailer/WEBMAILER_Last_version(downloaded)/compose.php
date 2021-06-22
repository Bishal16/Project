<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">
    <head>
            <title>Compose mail</title>
            <link rel="stylesheet" href="styles.css">
    </head>

    <body>  
            <div id="header">
                    <h1 >Web Mailer</h1>
                    <button  title="Profile" class="profile_icon"  onclick="window.location='profile.php'">   </button>     
                    
                    <div class="ppp">   <?php echo $_SESSION["user_mail"] ; ?></div>
            </div>

            <div id="main_div">
                    <div class="sidebar">                 
                        <ul>
                            <li ><a class="active" href="compose.php">Compose</a></li>
                            <li ><a href="inbox.php">Inbox</a></li>
                            <li ><a href="sentbox.php">Sent</a></li>
                            <li ><a href="draft.php">Draft</a></li>
                            <li ><a href="trash.php">Trash</a></li>
                            <li ><a href="profile.php">Profile</a></li>
                            <li ><a href="logout.php">Logout</a></li>

                        </ul>
                    </div>

                    <div class="main_body">
                    <!-- start -->
                    <?php
                        $nextstage=1;

                        $server      = "localhost";
                        $password    = "hsq7B5DLJvjVMUKX";
                        $user        = "ourcuet_bishal";
                        $database    = "ourcuet_bishaldbms3";
                        $connection = mysqli_connect($server, $user, $password, $database);



                        
                        if(isset($_POST['submit']))
                        {
                            $s_email=$_POST["from"];
                            $r_email=$_POST["to"];
                            $title=$_POST["tittle"];
                            $message=$_POST["message"];
                            $datee=date("Y-m-d");
                            $timee=date("h:i:sa");



                              //  ------------------------------------------check how many reciever   
                              $string=$r_email;
                              $string=$string." ";
                              $spacecount=0;
  
                              for($i=0;$i<strlen($string);$i=$i+1){
                                  if($string[$i]==" "){
                                      $spacecount=$spacecount+1;
                                  }
                              }
                              $email[$spacecount+1]=array();
                              $k=0;
                              for($i=0;$i<=$spacecount;$i=$i+1){
                                  $space=strpos($string," ");
                                  $email[$i]=substr($string,0,$space);
                                  $string = substr($string,$space+1,strlen($string));
                                  //echo $email[$i]."<br>";
                              }//--------------------------all recievers are in email[] array;
      
                            
                            
                            if(!$s_email){
                                alert( "*From required");
                                $nextstage = 0;
                            }
                            elseif(!$r_email){
                                alert(  "*To required");
                                $nextstage = 0;
                            }
                            elseif(!$title){
                                alert(  "*Tittle name required");
                                $nextstage = 0;
                            }
                            elseif(!$message){
                                alert(  "*Message name required");
                                $nextstage = 0;
                            }


                            $attachment=0;
                            if(isset($_POST["submit"]))
                            {
                                $attachment=1;
                                $file=$_FILES["file"]["name"];
                                $tmp_name=$_FILES["file"]["tmp_name"];
                                $path="upload/".$file;
                                $file1=explode(".",$file);
                                $ext=$file1[1];
                                $allowed=array("jpg","png","gif","pdf","zip","mp4","mkv");
                                if(in_array($ext,$allowed))
                                {
                                    move_uploaded_file($tmp_name,$path);                                                             
                                }
                            }
                        
                            if($spacecount==1)
                            {
                                if($nextstage==1 && $attachment==1)
                                {
                                    $sql= "Insert into inbox (s_email,r_email,title,message,datee,timee,file) values('$s_email','$r_email','$title','$message','$datee','$timee','$file')";
                                    $iquery = mysqli_query($connection,$sql);
                                    
                                    if($iquery)
                                    {
                                        echo "<script>
                                        alert('Mail sent seccessfully with Attachment');
                                        window.location.href='sentbox.php';
                                        </script>";
                                    }
                                    else
                                    {
                                        echo 'failed to insert data'.'<br>';
                                    }
                                }
                        
                                elseif($nextstage==1 && $attachment==0)
                                {
                                    $sql= "Insert into inbox (s_email,r_email,title,message,datee,timee) values('$s_email','$r_email','$title','$message','$datee','$timee')";
                                    $iquery = mysqli_query($connection,$sql);
                                    
                                    if($iquery)
                                    {
                                        echo "<script>
                                        alert('Mail sent seccessfully with Attachment');
                                        window.location.href='sentbox.php';
                                        </script>";
                                    }
                                    else
                                    {
                                        echo 'failed to insert data'.'<br>';
                                    }
                                }
                            }

                            else
                            {
                                //more user
                                for($i=0;$i<$spacecount;$i=$i+1)
                                {
                                    if($nextstage==1 && $attachment==1)
                                    {
                                        $sql= "Insert into inbox (s_email,r_email,title,message,datee,timee,file) values('$s_email','$email[$i]','$title','$message','$datee','$timee','$file')";
                                        $iquery = mysqli_query($connection,$sql);
                                        
                                        if($iquery)
                                        {
                                            echo "<script>
                                            alert('Mail sent seccessfully with Attachment');
                                            window.location.href='sentbox.php';
                                            </script>";
                                        }
                                        else
                                        {
                                            echo 'failed to insert data'.'<br>';
                                        }
                                    }
                        
                                    elseif($nextstage==1 && $attachment==0)
                                    {
                                        $sql= "Insert into inbox (s_email,r_email,title,message,datee,timee) values('$s_email','$email[$i]','$title','$message','$datee','$timee')";
                                        $iquery = mysqli_query($connection,$sql);
                                        
                                        if($iquery)
                                        {
                                            echo "<script>
                                            alert('Mail sent seccessfully with Attachment');
                                            window.location.href='sentbox.php';
                                            </script>";
                                        }
                                        else
                                        {
                                            echo 'failed to insert data'.'<br>';
                                        }
                                    }
                                }


                            }
                        }

                        ?>


                    <!-- finish -->
                        <form enctype="multipart/form-data"  method="post">
                            <input class="from" type="email" name="from" placeholder="From :" value=<?php echo $_SESSION["user_mail"] ; ?> readonly>
                           
                            <?php if($_SERVER["REQUEST_METHOD"]=="POST") {$tto=$_POST["to_value"];?>   
                            <input class="from" type="email" name="to" placeholder="To :" value=<?php echo $tto ?> readonly>
                            <?php }else{?> 
                            <input class="from" type="text" name="to" placeholder="To :" >
                            <?php }?>

                            <input class="from" type="text" name="tittle" placeholder="Tittle :">
                            <textarea class="massage" name="message" placeholder="Type your mail here .. "></textarea>
                            <br>
                            
                            <span id="attach">  Attach File : </span>
                            <input class="file_input" type="file" name="file">

                            <input type="submit" name="submit" value="send">
                            <button class="draft_button" type="submit" formaction="draft.php">save as draft</button>
                            <br>
                            <br>
                            <br>
                        </form>



                    </div>

                       
            </div>
    </body>
</html>