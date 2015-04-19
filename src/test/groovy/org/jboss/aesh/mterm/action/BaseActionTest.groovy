/*
 * JBoss, Home of Professional Open Source Copyright 2014 Red Hat Inc. and/or its affiliates and
 * other contributors as indicated by the @authors tag. All rights reserved. See the copyright.txt
 * in the distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License') you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in
 * writing, software distributed under the License is distributed on an 'AS IS' BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.jboss.aesh.mterm.action

import java.awt.event.ActionEvent

import javax.swing.JTextArea

import org.jboss.aesh.mterm.util.MtermUtil
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * @author <a href='mailto:00hf11@gmail.com'>Helio Frota</a>
 */
public class BaseActionTest {

  private JTextArea textArea
  private BaseAction action

  @Before
  public void setUp() {
    textArea = new JTextArea()
    MtermUtil.instance.createPs1('')
    action = new ClearAction(textArea)
  }

  @Test
  void testReadline() {
    textArea.setText('clear')
    Assert.assertEquals('clear', action.readLine())
    textArea.setText('')
    Assert.assertEquals('', action.readLine())
  }

  @Test
  public void testGetCommand() {
    textArea.setText('clear')
    Assert.assertEquals('clear', action.getCommand())
    textArea.setText('ls -l ')
    Assert.assertEquals('ls -l', action.getCommand())
    textArea.setText(' ls -l ')
    Assert.assertEquals('ls -l', action.getCommand())
    textArea.setText(' ls -l')
    Assert.assertEquals('ls -l', action.getCommand())
    textArea.setText(' ls     -l')
    Assert.assertEquals('ls     -l', action.getCommand())
  }
}