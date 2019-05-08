package org.sid.Controllers;

import java.util.List;

import org.sid.repository.SectionRepository;
import org.sid.Entities.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin( "*")
public class SectionController {
	@Autowired
	private 	SectionRepository sectionRepository;
	
	@RequestMapping(value="api/auth/Allsection",method=RequestMethod.GET)	
     public List<Section>getsection(){
    	return sectionRepository.findAll();
    }
   
	@RequestMapping(value="api/auth/section/{id}",method=RequestMethod.GET)	
	   public Section getsection(@PathVariable Long id){
		return sectionRepository.findById(id).orElse(null);
	}
		

	
	@RequestMapping(value="api/auth/Deletesection/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		sectionRepository.deleteById(id);	
		return true;
		}
	@RequestMapping(value="api/auth/savesection",method=RequestMethod.POST)
	public Section save(@RequestBody Section p) {
		return sectionRepository.save(p);
	}
   
 /*   @RequestMapping(value="/Updatesection/{id}",method=RequestMethod.PUT)
		public Section update (@PathVariable Long id,@RequestBody Section p ){ 
			p.setId_section(id);
			return sectionRepository.save(p);
			

}*/
	}
