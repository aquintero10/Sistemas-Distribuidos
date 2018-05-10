<?php 



if(isset($_GET['n1']) && isset($_GET['n2']) && isset($_GET['operacion'])) {

    $n1 = $_GET['n1'];
    $n2 = $_GET['n2'];
    $operacion = $_GET['operacion'];


    switch ($operacion) {
        case 'potencia':
            $resultado = pow($n1,$n2);
            break;
        case 'raiz':
            $resultado = sqrt($n1);
            break;
        case 'sen':
            $resultado = sin($n1);
            break;
        case 'cos':
            $resultado = cos($n1);
            break;
        case 'tan':
            $resultado = tan($n1);
            break;
        case 'isen':
            $resultado = asin($n1);
            break;
        case 'icos':
            $resultado = acos($n1);
            break;
        case 'itan':
            $resultado = atan($n1);
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