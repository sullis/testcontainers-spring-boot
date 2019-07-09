/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Playtika
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.testcontainers.couchbase;

import com.testcontainers.couchbase.legacy.LegacyClientConfiguration;
import com.testcontainers.couchbase.springdata.CouchbaseConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {CouchbaseConfiguration.class, LegacyClientConfiguration.class},
        properties = {"spring.profiles.active=enabled"}
)
public abstract class EmbeddedCouchbaseBootstrapConfigurationTest {

    @Autowired
    ConfigurableEnvironment environment;

    @Test
    public void propertiesAreAvailable() {
        assertThat(environment.getProperty("embedded.couchbase.bootstrapHttpDirectPort")).isNotEmpty();
        assertThat(environment.getProperty("embedded.couchbase.bootstrapCarrierDirectPort")).isNotEmpty();
        assertThat(environment.getProperty("embedded.couchbase.host")).isNotEmpty();
        assertThat(environment.getProperty("embedded.couchbase.bucket")).isNotEmpty();
        assertThat(environment.getProperty("embedded.couchbase.user")).isNotEmpty();
        assertThat(environment.getProperty("embedded.couchbase.password")).isNotEmpty();
        assertThat(System.getProperty("com.couchbase.bootstrapHttpDirectPort")).isNotEmpty();
        assertThat(System.getProperty("com.couchbase.bootstrapCarrierDirectPort")).isNotEmpty();
    }
}