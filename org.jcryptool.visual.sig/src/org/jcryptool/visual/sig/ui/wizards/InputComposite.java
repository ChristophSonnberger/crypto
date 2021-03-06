//-----BEGIN DISCLAIMER-----
/*******************************************************************************
* Copyright (c) 2013 JCrypTool Team and Contributors
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
//-----END DISCLAIMER-----
package org.jcryptool.visual.sig.ui.wizards;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * This class contains the GUI elements for first page of the file input wizard.
 * 
 * @author Grebe
 */
public class InputComposite extends Composite {
    private Button rdoFromFile;
    private Button rdoFromEditor;

    public InputComposite(Composite parent, int style) {
        super(parent, style);

        rdoFromFile = new Button(this, SWT.RADIO);
        rdoFromFile.setBounds(10, 10, 91, 18);
        rdoFromFile.setText(Messages.InputWizard_rdoFromFile);

        rdoFromEditor = new Button(this, SWT.RADIO);
        rdoFromEditor.setBounds(10, 34, 157, 18);
        rdoFromEditor.setText(Messages.InputWizard_rdoFromEditor);
        parent.setSize(600, 400);

        rdoFromFile.setSelection(true);
    }

    /**
     * @return the rdoFromFile
     */
    public Button getRdoFromFile() {
        return rdoFromFile;
    }

    /**
     * @return the rdoFromEditor
     */
    public Button getRdoFromEditor() {
        return rdoFromEditor;
    }
}
