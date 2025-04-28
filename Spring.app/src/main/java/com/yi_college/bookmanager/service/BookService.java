package com.yi_college.bookmanager.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yi_college.bookmanager.model.Book;


@Service
public class BookService {
	
	
	
    
    public List<Book> getBooks(){
    	return  Arrays.asList(
     		   
        		new Book(1,"ハリーポッター","J.K.ローリング","株式会社静山社",LocalDate.of(1999,12, 1),7),
        		new Book(2,"星の王子様","アントワーヌ.ド.サン=テグジュペリ","新潮社",LocalDate.of(2006,3,28),3),
        		new Book(3,"人間失格","太宰治","新潮社",LocalDate.of(2006,1,1),4),
        		new Book(4,"吾輩は猫である","夏目漱石","文藝春秋",LocalDate.of(2011,11,10),4),
        		new Book(5,"たけくらべ","樋口一葉","集英社",LocalDate.of(1993,12,15),5)
        				
        		   );
	
		
		
	}
	
			

}
