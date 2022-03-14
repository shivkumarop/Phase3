package com.project.Feedback;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice2.entities.Feedback;
import com.practice2.repo.FeedbackRepository;

@SpringBootTest
class FeedbackApplicationTests {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	FeedbackRepository feedbackRepo;
	
//	@Autowired
	
	@Test
	void shouldFindByUser() {
		Feedback testFeedback = new Feedback("Dummy Test", 5, "dummy");
		entityManager.persist(testFeedback);
		entityManager.flush();
		Feedback cmp = feedbackRepo.findByUser(testFeedback.getUser());
		assertEquals(cmp.getUser(), testFeedback.getUser());
	}
}
