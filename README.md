# Biblioteca CDI no Quarkus

## Visão Geral

Este é um guia sobre Contexts and Dependency Injection (CDI) no Quarkus. Este README fornece informações essenciais para começar a usar a biblioteca em seu projeto Quarkus. A biblioteca ArC é baseada na especificação Jakarta Contexts and Dependency Injection 4.0. Ela implementa a especificação CDI Lite, com melhorias específicas.

## Uso Básico

O CDI (Contexts and Dependency Injection) no Quarkus utiliza anotações para injetar dependências e gerenciar o ciclo de vida dos objetos. Abaixo estão algumas das anotações mais comuns usadas:

- `@ApplicationScoped`: Essa anotação marca uma classe como escopo de aplicação, o que significa que uma única instância será compartilhada por toda a aplicação. A instância é criada apenas quando um método é chamado pela primeira vez. No mais, comportamento similar ao `@Singleton`.

- `@Singleton`: Esta anotação marca uma classe como escopo Singleton, o que significa que uma única instância será compartilhada por toda a aplicação. A instância é criada quando o **Bean** é injetado e não possui [client proxy](https://quarkus.io/guides/cdi#client_proxies).

- `@Dependent`: Esta anotação marca uma classe como escopo Dependent, o que significa que uma nova instância será criada para cada injeção.

- `@RequestScoped`: Essa anotação marca uma classe como escopo de requisição, o que significa que uma nova instância será criada para cada requisição HTTP.

- `@SessionScoped`: Essa anotação marca uma classe como escopo de sessão, o que significa que uma única instância será compartilhada por toda a sessão do usuário. Apenas disponível se usar a extensão [quarkus-undertow](https://quarkus.io/extensions/io.quarkus/quarkus-undertow).

- `@TransactionScoped`: Essa anotação marca uma classe como escopo de Transação, compartilhando o mesmo contexto entre os **Beans** da transação atual. Apenas disponível se usar a extensão [quarkus-narayana-jta](https://quarkus.io/guides/transaction).

- `@Named`: Use esta anotação para nomear um bean CDI para que ele possa ser referenciado ao fazer `@Inject`. O **Bean** não será removido, mesmo se não for usado.

- `@Vetoed`: Esta anotação é usada para marcar uma classe que deve ser ignorada pelo CDI. Isso pode ser útil para evitar que uma classe seja considerada como um bean CDI.

- `@Inject`: Use esta anotação para injetar uma dependência em um componente gerenciado pelo CDI. Por exemplo:

- `@WithCaching`: Permite realizar Cache da instância do **Bean** que foi injetado na classe usando `@Inject`.

## Outras Annotations

Além das anotações básicas mencionadas acima, no Quarkus oferece suporte a várias outras anotações:

- `@Qualifier`: Esta anotação é usada para criar qualificadores personalizados. Os qualificadores ajudam a diferenciar implementações de uma mesma interface que podem ser injetadas.

- `@Produces`: Esta anotação é usada para criar e disponibilizar objetos gerenciados pelo CDI em um contexto. Você pode criar um método para produzir um objeto e torná-lo disponível para injeção.

- `@Disposes`: Esta anotação é usada em conjunto com `@Produces` para marcar um método que é responsável por destruir uma instância criada por um método `@Produces`.

- `@Decorator`: Anotação usada para criar decoradores que adicionam comportamento a um bean CDI. Os decoradores implementam interfaces que definem os métodos decorados.

- `@Interceptor`: Use esta anotação para criar interceptadores CDI que podem ser usados para adicionar lógica adicional a métodos ou classes.

- `@AroundConstruct`: Marca um método que será executado na classe de `@Interceptor`. Sendo usado para adicionar lógica no momento que for ser instanciado o **Bean**.

- `@AroundInvoke`: Marca um método que será executado na classe de `@Interceptor`. Sendo usado para adicionar lógica adicional antes ou após a execução a método.

- `@NoClassInterceptors`: Ignora os `@Interceptor` definidos na classe, sendo executados apenas os que estão definidos diretamente no método ou construtor. Utilizado quando a classe possui um `@Interceptor`, o método possui outro `@Interceptor` possuindo uma regra semelhante ou quando não deseja executar o `@Interceptor` da classe para o método em questão.

- `@Alternative`: Esta anotação é usada para marcar uma implementação alternativa de um **Bean**. É útil para alterar o comportamento de **Bean** presente em alguma biblioteca de terceiros ou do próprio Quarkus.

- `@Specializes`: Use esta anotação para criar uma classe que especializa outra classe, herdando seus métodos, campos e substituindo seu comportamento. Seu uso é para quando deseja um **Bean** totalmente novo. Semelhante ao `@Alternative`, porém mantém apenas esse **Bean**, sem instâncias alternativas.

- `@Priority`: Permite definir a prioridade de um bean CDI em relação a outros beans do mesmo tipo. Isso é útil quando há vários beans compatíveis e você deseja especificar a ordem de seleção. Usando em conjunto com `@Alternative`, `@Decorator`, `@Interceptor`.

- `@Any`: Esta anotação é usada para injetar qualquer **Bean** que corresponda ao tipo especificado, independentemente dos qualificadores.

- `@All`: Esta anotação é usada para injetar todos os **Bean** que correspondam ao tipo especificado, independentemente dos qualificadores.

- `@Default`: É o `@Qualifier` padrão para os **Bean** e `@Inject`. Sendo adicionado automaticamente quando nenhum outro `@Qualifier` foi usado.

- `@PostConstruct`: Esta anotação é usada para marcar um método que deve ser executado após a criação de um bean CDI. É útil para realizar inicializações específicas do bean.

- `@PreDestroy`: Marca um método que será executado antes que um bean CDI seja destruído. Isso é útil para realizar ações de limpeza ou liberação de recursos.

- `@Observes` ou `@ObservesAsync`: Esta anotação é usada para criar métodos observadores que reagem a eventos CDI. Os métodos marcados com @Observes podem ser acionados quando ocorrerem eventos específicos.

- `@Startup`: Marca um bean para ser inicializado juntamente ao servidor. Porém é recomendado criar um método usando `@Observes StartupEvent event`.

- `@ActivateRequestContext`: Possibilita adicionar o contexto de requisição em um método ou classe que não possui contexto. Por exemplo em Threads que precisam realizar selects.

- `@Unremovable`: Usada para marcar um **Bean** como "não removível". Isso significa que o **Bean** não será removido da aplicação, mesmo se não for usado explicitamente.

- `@IfBuildProfile` ou `@UnlessBuildProfile`: Permite criar um **Bean** somente para os Profiles desejados. Necessário utilizar também `@DefaultBean`, definindo um **Bean** para os outros Profiles que não atendem a condição. Normalmente utilizado em métodos juntamente com `@Produces`.

- `@IfBuildProperty` ou `@UnlessBuildProperty`: Permite criar um **Bean** baseado em uma property definida no arquivo de configuração ou variável de ambiente. Necessário utilizar também `@DefaultBean`, definindo um **Bean** para quando a property não atender a condição. Normalmente utilizado em métodos juntamente com `@Produces`.

- `@LookupIfProperty` ou `@LookupUnlessProperty`: Utilizado para fazer o `@Inject` de um **Bean** baseado no arquivo de configuração ou variável de ambiente. Usado em classes quando não possui `@Qualifier` para escolher qual **Bean** será injetado.

- `@ConfigProperty`: Usada para injetar valores de configuração definidos em arquivos de propriedades ou variáveis de ambiente. Isso permite que você configure beans com propriedades externas.

- `@Lock`: Usado para definir o funcionamento do acesso concorrente ao **Bean**. Normalmente utilizando juntamente com `@ApplicationScoped` e `@Singleton`.
