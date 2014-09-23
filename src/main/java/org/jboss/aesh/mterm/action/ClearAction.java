/*
 * JBoss, Home of Professional Open Source Copyright 2014 Red Hat Inc. and/or its affiliates and
 * other contributors as indicated by the @authors tag. All rights reserved. See the copyright.txt
 * in the distribution for a full listing of individual contributors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in
 * writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.jboss.aesh.mterm.action;

import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import org.jboss.aesh.mterm.gui.MessageDialog;
import org.jboss.aesh.mterm.util.MtermUtil;

/**
 * ClearAction class.
 *
 * This action clears the terminal and is fired when user types control + l.
 * 
 * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
 */
@SuppressWarnings("serial")
public class ClearAction extends BaseAction {

    /**
     * Parametric constructor initializes this action with JTextArea.
     * 
     * @param textArea JTextArea
     */
    public ClearAction(JTextArea textArea) {
        super(textArea);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            textArea.getDocument().remove(0, textArea.getDocument().getLength());
        }
        catch (BadLocationException e) {
            new MessageDialog().error(e.getMessage());
        }
        System.out.print(MtermUtil.INSTANCE.getPs1());

    }
    
    protected void perform() {
        
    }
}
