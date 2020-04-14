<?php
    include "php/db_control.php";
    require 'php/somefun.php';
    session_start();

    $db = new db_control();
    $fun = new somefun();
    $user_id = $_SESSION["USER_ID"];    
    $tokan = $_SESSION["TOKAN"];
    $group_name = $_SESSION["GROUP_NAME"];
    $group_id = $_SESSION["GROUP_ID"];

    $data = $db->get_data("name","members","group_id","$group_id AND is_deleted = false","",1);
    
    $mem = array();

    while ($rows = mysql_fetch_array($data)):
            $Name = $rows['name'];
            $mem[] = $Name;
    endwhile;  

   
?>

    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Loan Distribute</title>
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/styl.css" rel="stylesheet">
        </head>
        <body>
<!--start header -->
        <div class="container-fluid navbar-inverse" style=" color:white;">
        <!-- get the group name;-->
        <h1 class=" text-center text-white">
<?php
    echo strtoupper($group_name); 
 ?> 
        </h1>         
        </div>
<!--end header -->
        <div>
            <nav class=" navbar-inverse" style="font-size:15px;border-top:0.5px solid white;" id="navbar">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li class=""><a href="dashboard.php">Home</a></li>
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Member <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="addmember.php">Add</a></li>
                                        <li><a href="update.php">Update</a></li>
                                        <li><a href="#">Delete</a></li>
                                        <li><a href="#">View</a></li>
                                    </ul>
                            </li>
                            <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Savings <span class="caret"></span></a>
                                    <ul class="dropdown-menu ">
                                        <li><a href="addsavings.php">Add </a></li>
                                        <li><a href="#">View </a></li>
                                    </ul>
                            </li>
                            <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Get Loan<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Add EMI</a></li>
                                        <li><a href="#">View EMI</a></li>
                                        <li><a href="#">New Loan</a></li>
                                    </ul>
                            </li>
                            <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Total Collection<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Total Fund</a></li>
                                        <li><a href="#">Total Loan</a></li>
                                    </ul>
                            </li>
                          </ul>
                          <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>

        <div class="row">
            <div class="container">
                <div class="page-header text-center">
                    <h1>Loan Distrubute</h1>                
                </div>
            </div>
        </div>

<!---start page--->
<form action="" method="POST">
       
                <div class="container">
                    <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="member">Select Member*</label>
                            <select class="form-control" id="member" name="member_name" required>
                                <option selected="true" hidden>Select Member</option>

                                <!-- php code to fetch members from db -->
                                <?php
                                    foreach ($mem as $var ) {
                                        echo "<option>$var</option>";
                                    }    
                                ?>
                                   
                            </select>
                        </div>

                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="amt">Loan Amount :</label>
                            <input class="form-control" id="amt" type="text" name="loanamt" placeholder="amt">
                        </div>
                    </div>
                            

                    <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="member">Witness-1*</label>
                            <select class="form-control" id="member" name="member_name" required>
                                <option selected="true" hidden>Select Witness</option>

                                <!-- php code to fetch members from db -->
                                <?php
                                    foreach ($mem as $var ) {
                                        echo "<option>$var</option>";
                                    }    
                                ?>
                                   
                            </select>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="member">Witness-2*</label>
                            <select class="form-control" id="member" name="member_name" required>
                                <option selected="true" hidden>Select Witness</option>

                                <!-- php code to fetch members from db -->
                                <?php
                                    foreach ($mem as $var ) {
                                        echo "<option>$var</option>";
                                    }    
                                ?>
                                   
                            </select>
                        </div>
                    </div>    
                      

                        <div class="form-group row">
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                <label for="dob">Loan Date</label>
                                    <input class="form-control" id="loandate" type="date" name="loandate" placeholder="Today's Date" value="<?php echo date('Y-m-d');  ?>" readonly>
                            </div>
                        
                            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                 <label for="witness">Month</label>
                                    <select class="form-control" id="witness2" name="witness 2">
                                        <option value="1">January</option>      
                                        <option value="2">February</option>      
                                        <option value="3">March</option>      
                                        <option value="4">April</option>      
                                        <option value="5">May</option>      
                                        <option value="6">June</option>      
                                        <option value="7">July</option>      
                                        <option value="8">August</option>      
                                        <option value="9">September</option>      
                                        <option value="10">October</option>      
                                        <option value="11">November</option>      
                                        <option value="12">December</option>
                                    </select>
                            </div>

                            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                 <label for="witness">year</label>
                                    <select class="form-control" id="witness2" name="witness 2" >
                                        <option>
                                            <?php echo date('Y');  ?>          
                                        </option>
                                        <option>2019</option>
                                        <option>2020</option>
                                        <option>2021</option>
                                        <option>2022</option>
                                        <option>2023</option>      
                                        
                                    </select>
                            </div>
                        </div>
                       

                        <div class="form-group row">
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                <label for="rate">Interest Rate :</label>
                                <input class="form-control" id="interestrate" type="text" name="rate" placeholder="Rate">      
                            </div>
                        
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                <label for="mode">Mode :</label>
                                <input class="form-control" id="mode" type="text" name="mode" placeholder="Mode">
                            </div>
                        </div>
                        

                        <div class="form-group row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <label for="rate">Remark :</label>
                                <input class="form-control" id="remark" type="text" name="remark" placeholder="Remark">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                <label></label>
                                <button type="submit" name="Loan" class="btn btn-primary btn-lg btn-block">Take Loan</button>
                           </div>

                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                <label></label>
                                <input type="reset" name="Reset" value="Clear" class="btn btn-info btn-lg btn-block">
                            </div>
                        </div>        
                    </div>
                </form>


<!---End page--->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/myjs.js"></script>

    </body>
<!---end body--->
</html>