package br.com.fiap.convidados.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConvidadosDtoTests {

	@Test
	public void deveTestarGetSetConvidados() {
		//Cenario
		ConvidadosDto dto = new ConvidadosDto();
		ConvidadosDto dto1 = new ConvidadosDto();
		ConvidadosDto dto2 = null;
		
		//Acao
		dto.setNome("Teste");
		dto.setId(1L);
		dto.setEmail("teste@email.com");
		dto.setAcompanhante("02");
		
		dto1.setNome("Teste");
		dto1.setId(1L);
		dto1.setEmail("teste@email.com");
		dto1.setAcompanhante("02");
		
		//Validacao		
		assertTrue("02".equals(dto.getAcompanhante()));
		assertFalse("01".equals(dto.getAcompanhante()));
		assertEquals("02",dto.getAcompanhante());
		assertEquals("02",dto.getAcompanhante());
		assertEquals(dto,dto1);
		assertSame(dto,dto);
		assertNotSame(dto,dto1);
		assertNull(dto2);
		assertNotNull(dto);
	}
}
