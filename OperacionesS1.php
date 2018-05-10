<?php 



if(isset($_GET['n1']) && isset($_GET['n2']) && isset($_GET['operacion'])) {

    $n1 = $_GET['n1'];
    $n2 = $_GET['n2'];
    $operacion = $_GET['operacion'];


    switch ($operacion) {
        case 'suma':
            $resultado = $n1+$n2;
            break;
        case 'resta':
            $resultado = $n1-$n2;
            break;
        case 'multiplicacion':
            $resultado = $n1*$n2;
            break;
        case 'division':
            $resultado = $n1/$n2;
            break;
        case 'porcentaje':
            $resultado = ($n1*$n2)/100;
            break;
        case 'memoria':
            $resultado = $n1+$n2;
            break;
        
        default:
            $resultado ='error';
            break;
    }

		header('Content-type: application/json');
		echo json_encode(array('resultado' => $resultado));

}else{
    header('Content-type: application/json');
	echo json_encode(array("status" => -1, "info" => "parametros no definidos"));
}
?>