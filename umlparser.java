

package com.github.javaparser;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.comments.CommentsCollection;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;

import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExplicitConstructorInvocationStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.javadoc.Javadoc;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;

import static com.github.javaparser.ParseStart.*;
import static com.github.javaparser.Providers.*;
import static com.github.javaparser.utils.Utils.assertNotNull;

 private final CommentsInserter commentsInserter;
    private final ParserConfiguration configuration;

    private ASTParser aParser = null;

    /**
     * Instantiate the parser with default configuration. Note that parsing can also be done with the static methods on
     * this class.
     * Creating an instance will reduce setup time between parsing files.
     */
    public JavaParser() {
        this(new ParserConfiguration());
    }

 public JavaParser(ParserConfiguration configuration) {
        this.configuration = configuration;
        commentsInserter = new CommentsInserter(configuration);
    }

}
