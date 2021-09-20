package com.hugo.apimascotas.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugo.apimascotas.dao.MascotaDao;
import com.hugo.apimascotas.entity.Mascota;

@RestController
@RequestMapping("mascota")
public class MascotaRest {

	@Autowired
	private MascotaDao mascotaDao;

	@GetMapping
	public ResponseEntity<List<Mascota>> todasMascotas() {
		List<Mascota> mascotas = mascotaDao.findAll();

		return ResponseEntity.ok(mascotas);
	}

	@GetMapping("{id}")
	public ResponseEntity<Optional<Mascota>> mascotaById(@PathVariable Long id) {
		Optional<Mascota> byIdMascota = mascotaDao.findById(id);
		if (byIdMascota.isPresent()) {
			return ResponseEntity.ok(byIdMascota);

		} else {
			return ResponseEntity.noContent().build();

		}

	}

	@PostMapping
	public ResponseEntity<Mascota> createMascota(@RequestBody Mascota mascota) {
		Mascota mascotaNueva = mascotaDao.save(mascota);

		return ResponseEntity.ok(mascotaNueva);

	}

	@PutMapping("{id}")
	public ResponseEntity<Mascota> updateMascota(@RequestBody Mascota mascota, @PathVariable Long id) {
		Optional<Mascota> mascotaUpdate = mascotaDao.findById(id);

		if (mascotaUpdate.isPresent()) {
			mascotaUpdate.get().setNombre(mascota.getNombre());
			mascotaUpdate.get().setEdad(mascota.getEdad());
			mascotaUpdate.get().setDescripcion(mascota.getDescripcion());
			mascotaDao.save(mascotaUpdate.get());
			return ResponseEntity.ok(mascotaUpdate.get());

		} else {
			return ResponseEntity.noContent().build();

		}

	}

	@DeleteMapping("{id}")
	public String deleteMascota(@PathVariable Long id) {
		if (mascotaDao.findById(id).isPresent()) {
			mascotaDao.deleteById(id);
			return "Mascota eliminada";
		}
		return "Mascota con id  " + id + " no existe ";

	}
}