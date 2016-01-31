package com.nonfunc.jpa.existence;

/*
 * #%L
 * em
 * %%
 * Copyright (C) 2016 nonfunc.com
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import static com.airhacks.rulz.em.EntityManagerProvider.persistenceUnit;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

import com.airhacks.rulz.em.EntityManagerProvider;

public class ExistenceCheckerTest {

	private static Logger logger = Logger.getLogger(ExistenceCheckerTest.class.getName());
	private static EntityManager entityManager;
	private static EntityTransaction transaction;
	private static ExistenceChecker checker;

	@ClassRule
	public static EntityManagerProvider provider = persistenceUnit("existence-check");

	@Rule
	public Stopwatch stopwatch = new Stopwatch() {
		@Override
		protected void finished(long nanos, Description description) {
			log(description.getMethodName(), nanos);
		}
	};

	@BeforeClass
	public static void setUp() throws Exception {
		entityManager = provider.em();
		transaction = provider.tx();
		transaction.begin();

		FooFactory.create(entityManager, 100000);
		entityManager.flush();
		entityManager.clear();

		checker = new ExistenceChecker(entityManager);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		transaction.rollback();
	}

	@Test
	public void testFastExistenceCheck() {
		assertTrue(checker.fastExistenceCheck());
	}

	@Test
	public void testFastExistenceCheckExact() {
		assertTrue(checker.fastExistenceCheckExact());
	}

	@Test
	public void testExists1() {
		assertTrue(checker.exists1());
	}

	@Test
	public void testExists2() {
		assertTrue(checker.exists2());
	}

	@Test
	public void testExists3() {
		assertFalse(checker.exists3());
	}

	@Test
	public void testExists4() {
		assertFalse(checker.exists4());
	}

	@Test
	public void testExists5() {
		assertFalse(checker.exists5());
	}

	@Test
	public void testExists6() {
		assertTrue(checker.exists6());
	}

	@Test
	public void testExists7() {
		assertTrue(checker.exists7());
	}

	@Test
	public void testExists8() {
		assertTrue(checker.exists8());
	}

	@Test
	public void testExists9() {
		assertFalse(checker.exists9());
	}

	@Test
	public void testExists10() {
		assertFalse(checker.exists10());
	}

	@Test
	public void testExists11() {
		assertFalse(checker.exists11());
	}

	@Test
	public void testExists12() {
		assertTrue(checker.exists12());
	}

	@Test
	public void testExists13() {
		assertTrue(checker.exists13());
	}

	@Test
	public void testExists14() {
		assertTrue(checker.exists14());
	}

	@Test
	public void testExists15() {
		assertFalse(checker.exists15());
	}

	@Test
	public void testExists16() {
		assertFalse(checker.exists16());
	}

	@Test
	public void testExists17() {
		assertFalse(checker.exists17());
	}

	@Test
	public void testExists18() {
		assertTrue(checker.exists18());
	}

	@Test
	public void testExists19() {
		assertFalse(checker.exists19());
	}

	@Test
	public void testExists20() {
		assertFalse(checker.exists20());
	}

	@Test
	public void testExists21() {
		assertTrue(checker.exists21());
	}

	private static void log(String test, long nanos) {
		logger.info(String.format("Test %s took %d milliseconds.", test, TimeUnit.NANOSECONDS.toMillis(nanos)));
	}
}
