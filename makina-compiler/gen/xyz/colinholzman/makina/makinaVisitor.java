// Generated from D:/Colin/My Documents/makina/makina-compiler/src\makina.g4 by ANTLR 4.9.1
package xyz.colinholzman.makina;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link makinaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface makinaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link makinaParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(makinaParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link makinaParser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(makinaParser.StateContext ctx);
	/**
	 * Visit a parse tree produced by {@link makinaParser#parent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(makinaParser.ParentContext ctx);
	/**
	 * Visit a parse tree produced by {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandler(makinaParser.HandlerContext ctx);
	/**
	 * Visit a parse tree produced by {@link makinaParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(makinaParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link makinaParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(makinaParser.GuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link makinaParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(makinaParser.TransitionContext ctx);
}