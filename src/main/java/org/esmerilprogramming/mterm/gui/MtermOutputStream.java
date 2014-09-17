/*
 * Copyright 2014 EsmerilProgramming.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.esmerilprogramming.mterm.gui;

import java.io.*;
import javax.swing.*;

/**
 * To write bytes on textArea. 
 *
 * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
 */
public class MtermOutputStream extends OutputStream {

  private JTextArea textArea;

  public MtermOutputStream(JTextArea textArea) {
    this.textArea = textArea;
  }

  @Override
  public void write(int b) throws IOException {
    this.textArea.append(String.valueOf((char) b));
    this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
  }

}