/*
 * Copyright 2001-2004 The Apache Software Foundation.
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
 */ 

package org.apache.commons.logging.log4j;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;


/**
 * A custom implementation of <code>org.apache.log4j.Appender</code> which
 * stores all received log event messages in memory. This allows test code
 * to check whether the messages it expected to log have actually been logged.
 * 
 *
 * @author Craig R. McClanahan
 * @version $Revision$ $Date$
 */

public class TestAppender extends AppenderSkeleton {



    // ----------------------------------------------------- Instance Variables


    // The set of logged events for this appender
    private List events = new ArrayList();


    // --------------------------------------------------------- Public Methods


    public Iterator events() {
        return (events.iterator());
    }


    public void flush() {
        events.clear();
    }


    // ------------------------------------------------------- Appender Methods


    protected void append(LoggingEvent event) {
        events.add(event);
    }


    public void close() {
    }


    public boolean requiresLayout() {
        return (false);
    }


}
