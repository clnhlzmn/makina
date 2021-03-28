// Generated from /Users/colinholzman/makina/makina-compiler/src/makina.g4 by ANTLR 4.9.1
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
	 * Visit a parse tree produced by {@link makinaParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(makinaParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code entryHandler}
	 * labeled alternative in {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntryHandler(makinaParser.EntryHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exitHandler}
	 * labeled alternative in {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitHandler(makinaParser.ExitHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eventHandler}
	 * labeled alternative in {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventHandler(makinaParser.EventHandlerContext ctx);
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
	 * Visit a parse tree produced by the {@code defaultTransition}
	 * labeled alternative in {@link makinaParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultTransition(makinaParser.DefaultTransitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code externalTransition}
	 * labeled alternative in {@link makinaParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalTransition(makinaParser.ExternalTransitionContext ctx);
}