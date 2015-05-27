/*
 * Copyright (C) 2015 Twitter, Inc.
 *
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
 *
 */

package com.twitter.sdk.android.core;

import io.fabric.sdk.android.FabricAndroidTestCase;

public class TwitterSessionTest extends FabricAndroidTestCase {

    public void testConstructor_noAuthToken() throws Exception {
        try {
            final TwitterSession session = new TwitterSession(null, TwitterSession.UNKNOWN_USER_ID,
                    TwitterSession.UNKNOWN_USER_NAME);
            fail();
        } catch (IllegalArgumentException ie) {
            assertEquals("AuthToken must not be null.", ie.getMessage());
        }
    }

    public void testEquals_sameObjects() throws Exception {
        final TwitterSession session = new TwitterSession(
                new TwitterAuthToken(TestFixtures.TOKEN, TestFixtures.SECRET), TestFixtures.USER_ID,
                TestFixtures.SCREEN_NAME);
        final TwitterSession newSession = new TwitterSession(
                new TwitterAuthToken(TestFixtures.TOKEN, TestFixtures.SECRET), TestFixtures.USER_ID,
                TestFixtures.SCREEN_NAME);
        assertEquals(session.hashCode(), newSession.hashCode());
        assertEquals(session, newSession);
    }

    public void testEquals_sameObjectsWithNullUserName() throws Exception {
        final TwitterSession session = new TwitterSession(
                new TwitterAuthToken(TestFixtures.TOKEN, TestFixtures.SECRET), TestFixtures.USER_ID,
                null);
        final TwitterSession newSession = new TwitterSession(
                new TwitterAuthToken(TestFixtures.TOKEN, TestFixtures.SECRET), TestFixtures.USER_ID,
                null);
        assertEquals(session.hashCode(), newSession.hashCode());
        assertEquals(session, newSession);
    }

    public void testEquals_diffObjects() throws Exception {
        final TwitterSession session = new TwitterSession(
                new TwitterAuthToken(TestFixtures.TOKEN, TestFixtures.SECRET), TestFixtures.USER_ID,
                TestFixtures.SCREEN_NAME);
        final long differentUserId = TestFixtures.USER_ID + 1;
        final TwitterSession newSession = new TwitterSession(
                new TwitterAuthToken(TestFixtures.TOKEN, TestFixtures.SECRET), differentUserId,
                TestFixtures.SCREEN_NAME);
        assertNotSame(session, newSession);
    }

    public void testEquals_diffObjectsWithNullUserName() throws Exception {
        final TwitterSession session = new TwitterSession(
                new TwitterAuthToken(TestFixtures.TOKEN, TestFixtures.SECRET), TestFixtures.USER_ID,
                null);
        final long differentUserId = TestFixtures.USER_ID + 1;
        final TwitterSession newSession = new TwitterSession(
                new TwitterAuthToken(TestFixtures.TOKEN, TestFixtures.SECRET), differentUserId,
                null);
        assertNotSame(session, newSession);
    }

}

