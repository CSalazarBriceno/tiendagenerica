package com.ubosque.tiendavirtual;
import com.unbosque.DAO.ProveedorDAO;
import com.unbosque.DTO.Proveedor;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/Proveedores")
public class ProveedorController {
	ProveedorDAO proveedorDAO = new ProveedorDAO();
		
		
		@RequestMapping("/Lista") //Esta es la API
		public ArrayList<Proveedor> listaProveedor(){
			return proveedorDAO.ListProviders();
		}
		
		//HTTP = HyperText transfer Protocol. CRUD 
		//Create = Post
		@PostMapping
		public Proveedor createProvider() {
			Proveedor proveedor = new Proveedor();
			proveedor.setNitProveedor(2);
			proveedor.setCiudadProveedor("Bogota");
			proveedor.setDireccionProveedor("calle2");
			proveedor.setNombreProveedor("prov2");
			proveedor.setTelefonoProveedor("234");
			proveedorDAO.saveProvider(proveedor);
			return proveedor;
		}
		
		
		//Read = Get
		@GetMapping(value="{nit}")
		public Proveedor providerByNit(@PathVariable("nit") int nit) {
			return proveedorDAO.readProviderByNit(nit);
		}
		
		
		//Update = Put
		@PutMapping
		public Proveedor updateProvider() {
			Proveedor proveedor = new Proveedor();
			proveedor.setNitProveedor(2);
			proveedor.setCiudadProveedor("BogotaMod");
			proveedor.setDireccionProveedor("calle2mod");
			proveedor.setNombreProveedor("Prov2mod");
			proveedor.setTelefonoProveedor("234mod");
			proveedorDAO.updateProvider(proveedor);
			return proveedor;
		}
		
		//Delete = Delete
		@DeleteMapping(value="{nit}")
		public void deleteProvider(@PathVariable("nit") int nit) {
			proveedorDAO.deleteProvider(nit);
		}

}
