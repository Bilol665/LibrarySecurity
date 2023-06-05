package uz.pdp.librarysecurity.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.librarysecurity.dto.BookCreateDto;
import uz.pdp.librarysecurity.entity.book.BookEntity;
import uz.pdp.librarysecurity.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    public BookEntity save(BookCreateDto bookCreateDto) {
        BookEntity map = modelMapper.map(bookCreateDto, BookEntity.class);
        return bookRepository.save(map);
    }
}
