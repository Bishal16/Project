<!DOCTYPE html>
<html lang="en">
<html>

<head>
    <script language="javascript" type="text/javascript">
    window.history.forward();
    </script>
    <title>Web Mailer</title>
    <link rel="stylesheet" href="style_login.css">
</head>

<body>
    <div id="header">
        <h3>Web Mailer</h3>
        <!-- <div class="ppp">   <?php echo $_SESSION["user_mail"] ; ?></div> -->
        

    </div>

    <div class="panel">
        <h1>Login</h1>
        <form action="login1.php" method="post">
            <div id=box> <input type="email" name="email" placeholder="Email.."></div>
            <div id=box> <input type="password" name="password" placeholder="Password.."></div>
            <div id=btn> <input id=btn type="submit" value="LOGIN"></div>
            <span><a href="signup.php">Don't have an account?Sign up</a> </span>
        </form>

    </div>

</body>

</html>
