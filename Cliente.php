
<?php

 
 
$n1 = $_POST["ans1"];
$n2 =  $_POST["ans2"];

$operacion = 'multiplicacion';

$response = file_get_contents("http://".$ip."/OperacionesS1.php?n1=".$n1."&n2=".$n2."&operacion=".$operacion."");
$resultado = json_decode($response);

echo $resultado -> resultado;

?>


