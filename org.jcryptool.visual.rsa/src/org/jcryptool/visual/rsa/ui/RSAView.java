// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2011 JCrypTool Team and Contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----
package org.jcryptool.visual.rsa.ui;

import java.util.HashMap;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.jcryptool.visual.rsa.Action;
import org.jcryptool.visual.rsa.Messages;
import org.jcryptool.visual.rsa.RSAData;
import org.jcryptool.crypto.ui.textblockloader.TextAsNumbersLoaderWizard;

/**
 * the view displaying this visualization.
 * 
 * @author Michael Gaber
 */
public class RSAView extends ViewPart {

	private Composite parent;

	@Override
	public final void createPartControl(final Composite parent) {
		this.parent = parent;
		final HashMap<Action, RSAData> datas = new HashMap<Action, RSAData>();
		final TabFolder tf = new TabFolder(parent, SWT.TOP);

		// Encrypt
		TabItem ti = new TabItem(tf, SWT.NONE);
		ti.setText(Messages.RSAComposite_encrypt);
		ScrolledComposite sc = new ScrolledComposite(tf, SWT.H_SCROLL
				| SWT.V_SCROLL);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		RSAComposite c = new RSAComposite(sc, SWT.NONE, Action.EncryptAction,
				datas);
		sc.setContent(c);
		sc.setMinSize(c.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		ti.setControl(sc);

		// Decrypt
		ti = new TabItem(tf, SWT.NONE);
		ti.setText(Messages.RSAComposite_decrypt);
		sc = new ScrolledComposite(tf, SWT.H_SCROLL | SWT.V_SCROLL);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		c = new RSAComposite(sc, SWT.NONE, Action.DecryptAction, datas);
		sc.setContent(c);
		sc.setMinSize(c.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		ti.setControl(sc);

		// Sign
		ti = new TabItem(tf, SWT.NONE);
		ti.setText(Messages.RSAComposite_sign);
		sc = new ScrolledComposite(tf, SWT.H_SCROLL | SWT.V_SCROLL);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		c = new RSAComposite(sc, SWT.NONE, Action.SignAction, datas);
		sc.setContent(c);
		sc.setMinSize(c.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		ti.setControl(sc);

		// Verify
		ti = new TabItem(tf, SWT.NONE);
		ti.setText(Messages.RSAComposite_verify);
		sc = new ScrolledComposite(tf, SWT.H_SCROLL | SWT.V_SCROLL);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		c = new RSAComposite(sc, SWT.NONE, Action.VerifyAction, datas);
		sc.setContent(c);
		sc.setMinSize(c.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		ti.setControl(sc);

		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(parent.getShell(), "org.jcryptool.visual.rsa.rsaview");
		
		// Test tab
		TabItem testtab = new TabItem(tf, SWT.NONE);
		testtab.setText("Test");
		sc = new ScrolledComposite(tf, SWT.H_SCROLL | SWT.V_SCROLL);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		
		final Composite testMainComp = new Composite(sc, SWT.NONE);
		GridData gd = new GridData();
		GridLayout gl = new GridLayout();
		testMainComp.setLayout(gl);
		testMainComp.setLayoutData(gd);
		
		Button testBtn = new Button(testMainComp, SWT.PUSH);
		testBtn.setText("Test");
		
		testBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = testMainComp.getShell();
				
				TextAsNumbersLoaderWizard wiz = new TextAsNumbersLoaderWizard(120, false);
				WizardDialog dialog = new WizardDialog(shell, wiz);
				
				dialog.open();
			}

			private void showMsgBox(Shell shell, String msgText) {
				MessageBox dialog = 
				  new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
				dialog.setText("Message");
				dialog.setMessage(msgText);

				dialog.open();
			}
		});
		
		
		sc.setContent(testMainComp);
		sc.setMinSize(testMainComp.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		testtab.setControl(sc);
		
		tf.setSelection(testtab);

	}

	@Override
	public void setFocus() {
	}

	public void reset() {
		Control[] children = parent.getChildren();
		for (Control control : children) {
			control.dispose();
		}
		createPartControl(parent);
		parent.layout();
	}
}
