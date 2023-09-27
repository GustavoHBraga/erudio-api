package br.com.erudio.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {
	
    // Aqui é criada uma instância estática de um objeto Mapper usando a classe DozerBeanMapperBuilder.
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
    // Método que mapeia um objeto de origem para um objeto de destino.
	public static <O,D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
    // Método que mapeia uma lista de objetos de origem para uma lista de objetos de destino.
	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();
		for (O o : origin) {
            // Para cada objeto na lista de origem, é feita a cópia para o objeto de destino e adicionada à lista.
			destinationObjects.add(mapper.map(o, destination));
		}
		return destinationObjects;
	}
}