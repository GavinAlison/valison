package com.alison.spring.ioc.t1;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition implements Condition {

	// 条件化bean， env环境变量中含有magic的property属性才会创建对应的Bean
	@Override
	public boolean matches(ConditionContext context,
			AnnotatedTypeMetadata metadata) {
		Environment env = context.getEnvironment();

		return env.containsProperty("magic");
	}

}
