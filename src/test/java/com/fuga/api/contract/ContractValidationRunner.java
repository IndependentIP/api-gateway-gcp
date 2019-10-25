package com.fuga.api.contract;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

/**
 * Verifies whether the exposed APIs are compliant to their contract
 */
@RunWith(Karate.class)
@KarateOptions(tags = {"~@ignore"})
public class ContractValidationRunner {
}
