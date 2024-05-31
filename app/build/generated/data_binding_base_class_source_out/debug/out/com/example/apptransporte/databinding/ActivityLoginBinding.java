// Generated by view binder compiler. Do not edit!
package com.example.apptransporte.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.apptransporte.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonLogin;

  @NonNull
  public final EditText editTextPassword;

  @NonNull
  public final EditText editTextUsuario;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ConstraintLayout main;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button buttonLogin,
      @NonNull EditText editTextPassword, @NonNull EditText editTextUsuario,
      @NonNull ImageView imageView, @NonNull ConstraintLayout main) {
    this.rootView = rootView;
    this.buttonLogin = buttonLogin;
    this.editTextPassword = editTextPassword;
    this.editTextUsuario = editTextUsuario;
    this.imageView = imageView;
    this.main = main;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonLogin;
      Button buttonLogin = ViewBindings.findChildViewById(rootView, id);
      if (buttonLogin == null) {
        break missingId;
      }

      id = R.id.editTextPassword;
      EditText editTextPassword = ViewBindings.findChildViewById(rootView, id);
      if (editTextPassword == null) {
        break missingId;
      }

      id = R.id.editTextUsuario;
      EditText editTextUsuario = ViewBindings.findChildViewById(rootView, id);
      if (editTextUsuario == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      return new ActivityLoginBinding((ConstraintLayout) rootView, buttonLogin, editTextPassword,
          editTextUsuario, imageView, main);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}