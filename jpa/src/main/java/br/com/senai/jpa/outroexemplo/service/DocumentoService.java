package br.com.senai.jpa.service;

import br.com.senai.jpa.dto.DocumentoDto;
import br.com.senai.jpa.dto.mapper.DocumentoMapper;
import br.com.senai.jpa.model.Documento;
import br.com.senai.jpa.repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public DocumentoDto salvar(DocumentoDto documentoDto) {
        Documento documentoSalvo = documentoRepository.save(DocumentoMapper.toEntity(documentoDto));
        return DocumentoMapper.toDto(documentoSalvo);
    }

    public List<DocumentoDto> listarTodas() {
        List<Documento> pessoasEntity = documentoRepository.findAll();
        List<DocumentoDto> dtos = new ArrayList<>();
        for (Documento documento : pessoasEntity) {
            dtos.add(DocumentoMapper.toDto(documento));
        }
        return dtos;
    }

    public Optional<DocumentoDto> buscarPorId(Long id) {
        Optional<Documento> documento = documentoRepository.findById(id);
        return documento.map(DocumentoMapper::toDto);
    }

    public void excluir(Long id) {
        documentoRepository.deleteById(id);
    }

}