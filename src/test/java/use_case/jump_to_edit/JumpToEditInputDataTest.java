package use_case.jump_to_edit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpToEditInputDataTest {

    @Test
    void testGetRecipeTitle() {
        // 创建JumpToEditInputData对象
        JumpToEditInputData inputData = new JumpToEditInputData("Recipe Title");

        // 使用断言验证getRecipeTitle方法返回预期值
        assertEquals("Recipe Title", inputData.getRecipeTitle());
    }

    @Test
    void testGetRecipeContent() {
        // 创建JumpToEditInputData对象
        JumpToEditInputData inputData = new JumpToEditInputData("Recipe Title");

        // 使用断言验证getRecipeContent方法返回预期值（应该为null）
        assertNull(inputData.getRecipeContent());
    }
}
