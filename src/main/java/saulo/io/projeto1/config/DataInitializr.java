package saulo.io.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import saulo.io.projeto1.entity.Useres;
import saulo.io.projeto1.repository.UseresRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UseresRepository repository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		List<Useres> lUseres = repository.findAll();

		if (lUseres.isEmpty()) {

			createdUseres("Saulo", "saulo.costa@");
			createdUseres("Gabriel", "gabriel.costa@");
			createdUseres("Dany", "dany.alvares@");
			createdUseres("Daniella", "daniella.alvares@");
		}
		/*
		 * Busca 1 registro pelo ID
		 * 
		 * Useres consulta = repository.getOne(2L);
		 * System.out.println(consulta.getName());
		 * 
		 * Deleta algum registro pelo ID
		 * 
		 * Useres delete = new Useres(); delete.setId(3L); repository.delete(delete);
		 * 
		 * Atualiza algum registro pelo ID
		 * 
		 * Useres update = repository.getOne(1L); update.setName("Iraci");
		 * 
		 * Salva dados
		 * 
		 * repository.save(update);
		 * 
		 * Busca um dado pelo meu método customizado
		 * 
		 * Useres useresName = repository.findByName("saulo");
		 * System.out.println(useresName.getName());
		 * 
		 * Busca um dado pelo metodo customizado usando @Query
		 * 
		 * Useres useresLike = repository.findByNameLike("Sa");
		 * System.out.println(useresLike.getName());
		 * 
		 * Busca um dado pelo nome ignorando o case
		 * 
		 * Useres useres = repository.findByNameIgnoreCase("SAULO");
		 * System.out.println(useres.getName());
		 */
	}

	public void createdUseres(String name, String email) {

		Useres useres = new Useres(name, email);

		repository.save(useres);
	}

}
