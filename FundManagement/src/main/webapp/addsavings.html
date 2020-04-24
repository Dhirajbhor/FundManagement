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


?>

    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Add Savings</title>
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
                                        <li><a href="#">view</a></li>
                                    </ul>
                            </li>
                            <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Get Loan<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Add EMI</a></li>
                                        <li><a href="#">View EMI</a></li>
                                        <li><a href="loand.php">New Loan</a></li>
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

        <div class="container">
            <!--Page Header-->
            <div class="page-header text-center">
                <h1>Add Savings</h1>                
            </div>
            <div>
                <form action="php/savings_add.php" method="POST">              

                    <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="member">Select Member*</label>
                            <select class="form-control" id="member" name="member_name" required>
                                <option selected="true" hidden>Select Member</option>

                                <!-- php code to fetch members from db -->
                                <?php
                                    while ($rows = mysql_fetch_array($data)):
                                        $Name = $rows['name'];
                                        echo "<option>$Name</option>";
                                    endwhile;    
                                ?>
                                   
                            </select>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">            
                            <label for="amount">Saving Amount*</label>
                            <input class="form-control" id="amount" type="number" name="saving_amount" placeholder="Enter amount" requireds>
                        </div>
                    </div>    

                    <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">            
                            <label for="to_date">Installment Date*</label>
                            <input class="form-control" id="to_date" type="date" name="ins_date" placeholder="amt" value="<?php echo date('Y-m-d');  ?>" required>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">            
                            <label for="month">Month</label>
                            <input class="form-control" id="month" type="text" name="month" placeholder="amt" value="<?php echo date('M-Y');  ?>" readonly="true">
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">            
                            <label for="late_charge">Late Charge</label>
                            <input class="form-control" id="late_charge" type="number" name="late_charge" placeholder="Enter amount" value="0" >
                        </div>

                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">            
                            <label for="extra_saving">Extra Saving</label>
                            <input class="form-control" id="extra_saving" type="number" name="extra_saving" placeholder="Enter amount">
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">            
                            <label for="remark">Remark</label>
                            <input class="form-control" id="remark" type="text" name="remark" placeholder="Enter amount"  value="paid" >
                        </div>
                    </div>    

                    <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">        
                            <label> </label>
                            <button type="submit" name="Loan" class="btn btn-primary btn-lg btn-block">Save</button>
                        </div>

                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"> 
                            <label> </label>
                            <input type="reset" name="Reset" value="Clear" class="btn btn-info btn-lg btn-block">
                        </div>    
                    </div>
                </form>        
            </div>
<!---main form--->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/myjs.js"></script>
    </body>
<!---end body--->
</html>