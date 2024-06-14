package pe.edu.idat.ec1_Flores_Carlos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImcController {
    @GetMapping("/calcularprecio")
    public String calcularprecio(){
        return  "calcularprecioFrom";
    }
}
@PostMapping("/calcularPrecio")
    public String calcularPrecio(@RequestParam double precioUnitario, @RequestParam int cantidad, Model model) {
        double precioTotal;
        if (cantidad > 20) {
            precioTotal = precioUnitario * cantidad * 0.9; // Descuento del 10%
        } else if (cantidad > 10) {
            precioTotal = precioUnitario * cantidad * 0.95; // Descuento del 5%
        } else {
            precioTotal = precioUnitario * cantidad; // Sin descuento
        }
        model.addAttribute("precioTotal", precioTotal);
        return "calcularPrecioResultado";
    }