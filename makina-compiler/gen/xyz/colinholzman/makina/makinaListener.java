// Generated from D:/Colin/My Documents/makina/makina-compiler/src\makina.g4 by ANTLR 4.9.1
package xyz.colinholzman.makina;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link makinaParser}.
 */
public interface makinaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link makinaParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(makinaParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(makinaParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link makinaParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(makinaParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(makinaParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link makinaParser#parent}.
	 * @param ctx the parse tree
	 */
	void enterParent(makinaParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#parent}.
	 * @param ctx the parse tree
	 */
	void exitParent(makinaParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 */
	void enterHandler(makinaParser.HandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 */
	void exitHandler(makinaParser.HandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link makinaParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(makinaParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(makinaParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link makinaParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(makinaParser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(makinaParser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link makinaParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(makinaParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(makinaParser.TransitionContext ctx);
}